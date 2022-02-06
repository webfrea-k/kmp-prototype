//
//  MainViewModel.swift
//  demo ios (iOS)
//
//  Created by Simon Hocevar on 19/01/2022.
//

import Foundation
import shared

class MainViewModel: NSObject, ObservableObject {
    
    let commonViewModel = CommonViewModel()
    @Published var posts: [PostItem]? = nil
    
    func getPosts() {
        commonViewModel.postsState().watch { postItems in
            self.posts = postItems as? [PostItem]
        }
        commonViewModel.getPosts()
    }
}
