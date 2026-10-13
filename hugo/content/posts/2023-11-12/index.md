+++
title = "GithubのAPIを叩き、リポジトリの情報をリストに表示する。一番下までスクロールされたら追加で取得し、Indicatorも表示する"
url = "2023-11-12"
date = "2023-11-12"
description = "GithubのAPIを叩き、リポジトリの情報をリストに表示する。一番下までスクロールされたら追加で取得し、Indicatorも表示する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2024/01"
+++

<br>

GithubのAPIを叩き、リポジトリの情報をリストに表示する。一番下までスクロールされたら追加で取得し、Indicatorも表示する方法です。

<img src="2023-11-12.gif" width="300px" alt="GithubのAPIを叩き、リポジトリの情報をリストに表示する。一番下までスクロールされたら追加で取得し、Indicatorも表示する方法です。">


<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var repositories: [Repository] = []
    @State var page = 1
    @State var isFetching = false
    @State var showingErrorAlert = false

    let gitHubAPIRepository = GitHubAPIRepository()

    var body: some View {
        List {
            ForEach(repositories) { repository in
                VStack(alignment: .leading) {
                    Text(repository.name)
                        .font(Font.system(size: 24).bold())
                    Text(repository.description ?? "")
                    Text("Star: \(repository.stargazersCount)")
                }
                .onAppear {
                    if repositories.last == repository {
                        fetchRepositories()
                    }
                }
            }

            HStack {
                if isFetching {
                    Spacer()
                    ProgressView()
                    Spacer()
                }
            }
        }
        .onAppear {
            fetchRepositories()
        }
        .alert("Error", isPresented: $showingErrorAlert) {
            Button("Close", action: {})
        } message: {
            Text("Failed to Fetch repositories.")
        }
    }

    @MainActor
    func fetchRepositories() {
        if isFetching {
            return
        }
        isFetching = true

        Task {
            do {
                repositories += try await gitHubAPIRepository.searchRepos(page: page, perPage: 20)
                page += 1
                isFetching = false
            } catch {
                isFetching = false
                showingErrorAlert = true
            }
        }
    }
}

#Preview {
    ContentView()
}
```


**Repository.swift**

```swift
import Foundation

struct GitHubAPIRepository {
    func searchRepos(page: Int, perPage: Int) async throws -> [Repository] {
        let url = URL(string: "https://api.github.com/search/repositories?q=swift&sort=stars&page=\(page)&per_page=\(perPage)")!
        let (data, _) = try await URLSession.shared.data(from: url)
        let response = try JSONDecoder().decode(GithubSearchResult.self, from: data)
        return response.items
    }
}

struct GithubSearchResult: Codable {
    let items: [Repository]
}

struct Repository: Codable, Identifiable, Equatable {
    let id: Int
    let name: String
    let description: String?
    let stargazersCount: Int

    enum CodingKeys: String, CodingKey {
        case id
        case name
        case description
        case stargazersCount = "stargazers_count"
    }
}
```


