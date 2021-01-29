//
//  MenuRenewer.swift
//  Algorithm
//
//  Created by 윤동민 on 2021/01/30.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct MenuRenewer {
    static var countHash: [Int: [String: Int]] = [:]
    
    static func solution(_ orders: [String], _ course: [Int]) -> [String] {
        var fullCourse: [[String]] = []
            
        orders.forEach { foods in
            var eachCouse: [String] = []
            foods.forEach { food in
                eachCouse.append(String(food))
            }
            fullCourse.append(eachCouse)
        }
        
        course.forEach { count in
            countHash.updateValue([:], forKey: count)
            fullCourse.forEach {
                dfs($0, [], index: 0, count: count)
            }
        }
        
        var answer: [String] = []
        countHash.forEach { (key, value) in
            let sortedHash = value.sorted(by: {
                $0.value > $1.value
            })
            .filter { $0.value >= 2 }
            
            if sortedHash.count == 0 { return }
            var count: Int = 0
            for index in 0..<sortedHash.count-1 {
                if sortedHash[index].value != sortedHash[index+1].value { break }
                count += 1
            }
            
            sortedHash[0...count].forEach {
                answer.append($0.key)
            }
        }
        
        return answer.sorted()
    }
    
    static func dfs(_ fullCourse: [String], _ state: [String], index: Int, count: Int) {
        if state.count == count {
            let ascState = state.sorted()
                .reduce("") { $0 + $1 }
            
            if let curOrderCount = countHash[count]![ascState] {
                countHash[count]!.updateValue(curOrderCount+1, forKey: ascState)
            } else {
                countHash[count]!.updateValue(1, forKey: ascState)
            }
            return
        }
        
        if index >= fullCourse.count { return }
        
        dfs(fullCourse, state, index: index+1, count: count)
    
        var state = state
        state.append(fullCourse[index])
        dfs(fullCourse, state, index: index+1, count: count)
    }
}
