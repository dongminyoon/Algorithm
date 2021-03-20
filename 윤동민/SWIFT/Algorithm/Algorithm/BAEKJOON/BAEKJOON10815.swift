//
//  BAEKJOON10815.swift
//  Algorithm
//
//  Created by USER on 2021/03/20.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON10815 {
    func solution() {
        let N           = Int(readLine() ?? "0") ?? 0
        let cards       = readLine()!.split(separator: " ").compactMap({ Int($0) })
        
        let M           = Int(readLine() ?? "0") ?? 0
        let searchCards = readLine()!.split(separator: " ").compactMap({ Int($0) })
        
        let sortedCards = cards.sorted(by: <)
        
        var answer = ""
        searchCards.forEach { searchCard in
            answer += self.isExistCards(from: sortedCards, targetNumber: searchCard) ? "1 " : "0 "
        }
        
        print(answer.trimmingCharacters(in: CharacterSet.whitespaces))
    }
    
    func isExistCards(from cards: [Int], targetNumber: Int) -> Bool {
        var leftThreshold: Int  = 0
        var rightThreshold: Int = cards.count-1
        
        var mid: Int
        
        while leftThreshold <= rightThreshold {
            mid = (leftThreshold + rightThreshold) / 2
            
            if cards[mid] == targetNumber { return true }
            
            if cards[mid] > targetNumber        { rightThreshold = mid - 1 }
            else if cards[mid] < targetNumber   { leftThreshold  = mid + 1 }
        }
        return false
    }
}
