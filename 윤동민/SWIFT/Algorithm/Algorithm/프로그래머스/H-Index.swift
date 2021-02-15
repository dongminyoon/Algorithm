//
//  H-Index.swift
//  Algorithm
//
//  Created by USER on 2021/02/14.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct H_Index {
    func solution(_ citations:[Int]) -> Int {
        var answer: Int = 0
        
        for indexI in 0..<citations.count {
            var moreCount: Int = 0
            var lessCount: Int = 0
            for indexJ in 0..<citations.count {
                if indexI == indexJ { continue }
                
                if citations[indexI] >= citations[indexJ] { moreCount += 1 }
                if citations[indexI] <= citations[indexJ] { lessCount += 1 }
            }
            
            if moreCount != lessCount { continue }
            answer = answer < moreCount ? moreCount : answer
        }
        
        return answer
    }
}
