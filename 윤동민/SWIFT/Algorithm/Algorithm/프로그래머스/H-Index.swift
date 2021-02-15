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
        
        var h_index: Int = 0
        
        while h_index <= citations.count {
            var moreThanHCount: Int = 0
            
            for citation in citations {
                if h_index > citation { continue }
                moreThanHCount += 1
            }
            
            if h_index <= moreThanHCount {
                answer = h_index >= answer ? h_index : answer
            }
            
            h_index += 1
        }
        
        return answer
    }
}
