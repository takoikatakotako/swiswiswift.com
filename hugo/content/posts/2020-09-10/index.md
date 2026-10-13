+++
title =  "GithubのAPIを叩き、SwiftUIでリポジトリの情報をリストに表示する（Combine）"
url = "2020-09-10"
date = "2020-09-10"
description = "GithubのAPIを叩き、SwiftUIでリポジトリの情報をリストに表示する（Combine）"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/09"
+++

<br>

GithubのAPIを叩き、リポジトリの情報をリストに表示する方法です。
[Infinite List Scroll with SwiftUI and Combine](https://www.vadimbulavin.com/infinite-list-scroll-swiftui-combine/) を参考にさせていただきました。

![SwiftUI](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI
import Combine

enum GithubAPI {
    static func searchRepos(page: Int, perPage: Int) -> AnyPublisher<[Repository], Error> {
        let url = URL(string: "https://api.github.com/search/repositories?q=swift&sort=stars&page=\(page)&per_page=\(perPage)")!
        return URLSession.shared
            .dataTaskPublisher(for: url)
            .tryMap { try JSONDecoder().decode(GithubSearchResult.self, from: $0.data).items }
            .receive(on: DispatchQueue.main)
            .eraseToAnyPublisher()
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

struct ContentView: View {
    @State private var repositories: [Repository] = []
    @State private var subscriptions = Set<AnyCancellable>()
    @State private var showingAlert = false
    @State private var errorMessage = ""
    
    var body: some View {
        List(repositories) { repository in
            VStack(alignment: .leading) {
                Text(repository.name)
                    .font(Font.system(size: 24).bold())
                Text(repository.description ?? "")
                Text("Start: \(repository.stargazersCount)")
            }
        }.onAppear {
            GithubAPI.searchRepos(page: 1, perPage: 30)
                .sink(receiveCompletion: { completion in
                    switch completion {
                    case .finished:
                        break
                    case let .failure(error):
                        self.showingAlert = true
                        self.errorMessage = error.localizedDescription
                    }
                }, receiveValue: { repositories in
                    self.repositories = repositories
                })
                .store(in: &self.subscriptions)
        }
        .alert(isPresented: self.$showingAlert) {
            Alert(
                title: Text("Error"),
                message: Text(self.errorMessage),
                dismissButton: .default(Text("Close")))
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```

