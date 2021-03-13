//
//  BAEKJOON2805.swift
//  Algorithm
//
//  Created by USER on 2021/03/13.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON2805 {
    func solution() {
        let input         = readLine()!.split(separator: " ").compactMap({ Int(String($0)) })
        let treesHeight   = readLine()!.split(separator: " ").compactMap({ Int(String($0)) })
        
        let N = input[0]
        let M = input[1]
        /*
         N = 나무의 수
         M = 집에 가져가고 싶은 나무의 길이
         */
        
        let sortedTreesHeight = treesHeight.sorted(by: <)
        print(binarySearch(sortedTreesHeight, targetHeight: M))
    }
    
    func binarySearch(_ treesHeight: [Int], targetHeight: Int) -> Int {
        var maxHeight: Int = 0
        
        var leftThreshold: Int  = 0
        var rightThreshold: Int = treesHeight[treesHeight.count-1]
        
        var curHeight: Int
        var cuttedTreeHeight: Int64
        var restHeight: Int
        
        while leftThreshold <= rightThreshold {
            curHeight                   = (leftThreshold + rightThreshold) / 2
            cuttedTreeHeight            = 0
            
            for index in (0...treesHeight.count-1).reversed() {
                restHeight          = treesHeight[index] - curHeight
                if restHeight <= 0  { break }
                cuttedTreeHeight   += Int64(restHeight)
            }
            
            if cuttedTreeHeight >= targetHeight {
                if curHeight > maxHeight { maxHeight = curHeight }
                
                leftThreshold   = curHeight + 1
            } else {
                rightThreshold  = curHeight - 1
            }
        }
        
        return maxHeight
    }
}
