//
//  Problem2.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/07/16.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct Problem2 {
    func solution(arr: [[Int]]) -> [Int] {
        // Write your code here
        
        var decoded_decimal: [Int: Int] = [:]
        
        for indexI in 0..<arr.count {
            let decimal = decodeBinary(of: arr[indexI])
            decoded_decimal.updateValue(decimal, forKey: indexI)
        }
        
        let sorting_decimal = decoded_decimal.sorted { $0.value > $1.value }
        var result: [Int] = []
        sorting_decimal.forEach { each in
            result.append(each.key)
        }
        
        return result
    }

    func decodeBinary(of arr: [Int]) -> Int {
        let sorted_arr = arr.sorted(by: >)
        var decimal: Int = 0
        
        sorted_arr.forEach { each in
            var init_Value: Int = 1
            for _ in 0..<each { init_Value *= 2 }
            decimal += init_Value
        }
        
        return decimal
    }
}
