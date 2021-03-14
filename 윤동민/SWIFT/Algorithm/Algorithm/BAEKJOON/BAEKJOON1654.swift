//
//  BAEKJOON1654.swift
//  Algorithm
//
//  Created by USER on 2021/03/14.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON1654 {
    func solution() {
        let input = readLine()!.split(separator: " ").compactMap({ Int($0) })
        
        /*
         K = 이미 가지고 있는 랜선의 개수
         N = 필요한 랜선의 개수
         */
        let K = input[0]
        let N = input[1]
        
        var lanStripsLength: [Int] = []
        for _ in 1...K {
            let stripLength = Int(readLine()!)!
            lanStripsLength.append(stripLength)
        }
        
        lanStripsLength.sort(by: <)
        
        self.searchBinary(lanStripsLength: lanStripsLength, targetCount: N)
    }
    
    func searchBinary(lanStripsLength: [Int], targetCount: Int) {
        var maxLength: Int       = 0
        
        var leftThreshold: Int   = 1
        var rightThreshold: Int  = lanStripsLength[lanStripsLength.count-1]
        
        var mid: Int
        var stripCount: Int
        
        while leftThreshold <= rightThreshold {
            stripCount = 0
            mid = (leftThreshold + rightThreshold) / 2
            
            for length in lanStripsLength { stripCount += self.cutLanLength(by: mid, curLength: length) }
            
            if stripCount >= targetCount {
                if mid > maxLength { maxLength = mid }
                leftThreshold   = mid + 1
            } else {
                rightThreshold  = mid - 1
            }
        }
        
        print(maxLength)
    }
    
    func cutLanLength(by standardLength: Int, curLength: Int) -> Int {
        return curLength / standardLength
    }
}
