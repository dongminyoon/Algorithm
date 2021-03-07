//
//  BAEKJOON1920.swift
//  Algorithm
//
//  Created by USER on 2021/03/07.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON1920 {
    func solution() -> [Bool] {
        let _: Int = Int(readLine() ?? "0") ?? 0
        guard let inputNumbers = readLine() else { return [] }
        let splitNumbers = inputNumbers.split(separator: " ").map({ Int64($0) })
        let notNilNumbers = splitNumbers.compactMap { $0 }
        let sortedNumbers: [Int64] = notNilNumbers.sorted()
        
        let _: Int = Int(readLine() ?? "0") ?? 0
        guard let inputSearchNumbers = readLine() else { return [] }
        let splitSearchNumbers = inputSearchNumbers.split(separator: " ").compactMap({ Int64($0) })
        
        
        var answer: [Bool] = []
        splitSearchNumbers.forEach { searchNumber in
            let isExist = search(from: sortedNumbers, target: searchNumber)
            answer.append(isExist)
        }
        
        answer.forEach {
            print($0 ? "1" : "0", terminator: " ")
        }
        
        return answer
    }
    
    func search(from numbers: [Int64], target: Int64) -> Bool {
        var searchIndex: Int    = numbers.count / 2
        var leftThredhold: Int  = 0
        var rightThredhold: Int = numbers.count-1
        
        while true {
            let middleNumber = numbers[searchIndex]
        
            if target == middleNumber { return true }
            if rightThredhold - leftThredhold <= 0 { return false }
            
            if target > middleNumber {
                let nextIndex   = Double(searchIndex + rightThredhold) / 2.0
                leftThredhold   = searchIndex + 1
                searchIndex     = Int(ceil(nextIndex))
            } else {
                let nextIndex   = Double(searchIndex + leftThredhold) / 2.0
                rightThredhold  = searchIndex - 1
                searchIndex     = Int(floor(nextIndex))
            }
        }
    }
}
