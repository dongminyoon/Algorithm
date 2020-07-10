//
//  FoodLive.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/25.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct FoodLive {
    static func solution(_ food_times:[Int], _ k:Int64) -> Int {
        var k = k
        var index_food_times: [Int: Int] = [:]
        for index in 0..<food_times.count { index_food_times.updateValue(food_times[index], forKey: index+1) }
        
        var sorted = index_food_times.sorted { $0.value < $1.value }

        while true {
            let rest_time = k - Int64(sorted.count) * Int64(sorted[0].value)
            
            if rest_time > 0 {
                k = rest_time
                for index in (0..<sorted.count).reversed() {
                    let each_rest_time = sorted[index].value - sorted[0].value
                    if each_rest_time == 0 { sorted.remove(at: index) }
                    else { sorted[index].value -= sorted[0].value }
                }
            } else { break }
        }
        
        
        let sorted_by_key = sorted.sorted { $0.key < $1.key }
        let last_index = (k+1) % Int64(sorted_by_key.count)
        if last_index == 0 { return sorted_by_key[sorted_by_key.count-1].key }
        else { return sorted_by_key[Int(last_index)-1].key }
    }
}
