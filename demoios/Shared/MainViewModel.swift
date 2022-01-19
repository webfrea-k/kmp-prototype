//
//  MainViewModel.swift
//  demo ios (iOS)
//
//  Created by Simon Hocevar on 19/01/2022.
//

import Foundation
import shared


class MainViewModel: NSObject, ObservableObject {
    
    @Published var todo: Todo? = nil
    
    func getTodo() {
        Networking.shared.getTodo(completionHandler: { todoItem, error in
            self.todo = todoItem
        })
    }
}
