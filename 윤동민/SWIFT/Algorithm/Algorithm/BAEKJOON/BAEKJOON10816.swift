//
//  BAEKJOON10816.swift
//  Algorithm
//
//  Created by USER on 2021/03/20.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON10816 {
    func solution() {
        let N            = Int(readLine()!)!
        let cards: [Int] = readLine()!.split(separator: " ").map({ Int(String($0))! })
        
        let M           = Int(readLine()!)!
        let searchCards = readLine()!.split(separator: " ").map({ Int(String($0))! })
        
        var cardHash: [Int: Int] = [:]
        for card in cards {
            if cardHash.keys.contains(card) { cardHash[card] = cardHash[card]! + 1 }
            else { cardHash[card] = 1 }
        }
        
        var answer = ""
        
        for searchCard in searchCards {
            if cardHash.keys.contains(searchCard) { answer += "\(cardHash[searchCard]!)" + " " }
            else { answer += "0" + " " }
        }
        
        print(answer)
    }
}
