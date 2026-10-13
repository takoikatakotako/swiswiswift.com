+++
title =  "SwiftUIを使ったTODOアプリのサンプル"
url = "2020-12-10"
date = "2020-12-10"
description = "SwiftUIを使ったTODOアプリのサンプル"
tags = ["Swift", "SwiftUI"]
categories = ["Swift", "SwiftUI"]
archives = "2020/12"
+++

<br>

SwiftUIを使ったTODOアプリのサンプルコードです。
InputView で入力した TODOは ContentView に表示されます。

![TODO App Part1](1.gif)

![TODO App Part2](2.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View, InputViewDelegate {
    @State var todos: [String] = []
    
    var body: some View {
        NavigationView {
            ZStack(alignment: .bottomTrailing) {
                List {
                    ForEach(todos, id: \.self) { user in
                        Text(user)
                    }
                    .onDelete(perform: delete)
                }
                
                NavigationLink(destination: InputView(delegate: self, text: "")) {
                    Text("Add")
                        .foregroundColor(Color.white)
                        .font(Font.system(size: 20))
                }
                .frame(width: 60, height: 60)
                .background(Color.orange)
                .cornerRadius(30)
                .padding()
                
            }
            .onAppear {
                if let todos = UserDefaults.standard.array(forKey: "TODO") as? [String] {
                    self.todos = todos
                }
            }
            .navigationTitle("TODO")
            .navigationBarItems(trailing: EditButton())
        }
    }
    
    func delete(at offsets: IndexSet) {
        todos.remove(atOffsets: offsets)
        print(todos)
        UserDefaults.standard.setValue(todos, forKey: "TODO")
    }
    
    func addTodo(text: String) {
        todos.append(text)
        UserDefaults.standard.setValue(todos, forKey: "TODO")
    }
}

protocol InputViewDelegate {
    func addTodo(text: String)
}

struct InputView: View {
    @Environment(\.presentationMode) var presentation
    let delegate: InputViewDelegate
    @State var text: String
    var body: some View {
        VStack(spacing: 16) {
            TextField("Input Your TODO", text: $text)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            Button("Add") {
                delegate.addTodo(text: text)
                presentation.wrappedValue.dismiss()
            }
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

```

