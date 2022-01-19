//
//  ContentView.swift
//  Shared
//
//  Created by Simon Hocevar on 19/01/2022.
//

import SwiftUI

struct ContentView: View {
    @StateObject var viewModel = MainViewModel()

    var body: some View {
        Text(viewModel.todo?.title ?? "ERROR")
            .padding()
            .onAppear {
                viewModel.getTodo()
            }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
