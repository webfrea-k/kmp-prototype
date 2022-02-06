//
//  ContentView.swift
//  Shared
//
//  Created by Simon Hocevar on 19/01/2022.
//

import SwiftUI
import shared

struct ContentView: View {
    
    @StateObject var viewModel = MainViewModel()
    
    var body: some View {
        Text("Posts on \(UtilsKt.platformName())").font(Font.title)
        
        ScrollView(.vertical) {
            LazyVStack (alignment: .leading) {
                ForEach(viewModel.posts ?? [], id: \.self) {
                    Post(item: $0)
                }
            }.padding(5)
        }
        .onAppear {
            viewModel.getPosts()
        }
    }
}

struct Post : View {
    let item: PostItem
    var body: some View {
        VStack(alignment: .leading) {
            Text(item.title)
                .font(Font.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
                .padding(5)
            Text(item.body)
                .font(Font.body)
                .frame(maxWidth: .infinity, alignment: .leading)
                .padding(5)
            Divider()
        }
    }
}

