//
//  aawo.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/09/12.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var staticOrders: [String] = []

var orderComb: [[String: Int]] = Array(repeating: [:], count: 11)


func solution(_ orders:[String], _ course:[Int]) -> [String] {
    staticOrders = orders
    
    for courseCount in course {
        for index in 0..<orders.count {
            findComb(from: index, count: courseCount)
        }
    }
    
    var result: [String] = []
    
    for eachCourse in course {
        let sortingCourse = orderComb[eachCourse].sorted(by: { $0.value > $1.value })
        if let recommendedCourse = sortingCourse.first?.key, sortingCourse[0].value >= 2 { result.append(recommendedCourse) }
        
        if sortingCourse.count >= 2 {
            
            for index in 1..<sortingCourse.count {
                if sortingCourse[0].value == sortingCourse[index].value && sortingCourse[0].value >= 2 {
                    result.append(sortingCourse[index].key)
                }
            }
            
        }
    }
    
    result.sort()
    return result
}

func findComb(from ordersIndex: Int, count: Int) {
    
    let visited: [Bool] = Array(repeating: false, count: staticOrders[ordersIndex].count)
    dfs(ordersIndex: ordersIndex, of: "", index: 0, visited: visited, count: count)
}

func dfs(ordersIndex: Int, of string: String, index: Int, visited: [Bool], count: Int) {
    if string.count == count {
        var key: String = ""
        string.sorted().forEach { key += String($0) }
        
        if let eachComb = orderComb[count][key] {
            orderComb[count].updateValue(eachComb + 1, forKey: key)
        } else {
            orderComb[count].updateValue(1, forKey: key)
        }
        return
    }
    
    if index >= staticOrders[ordersIndex].count { return }
    
    var string = string
    var visited = visited
    
    dfs(ordersIndex: ordersIndex, of: string, index: index+1, visited: visited, count: count)
    
    let stringIndex = staticOrders[ordersIndex].index(staticOrders[ordersIndex].startIndex, offsetBy: index)
    string += String(staticOrders[ordersIndex][stringIndex])
    visited[index] = true
    dfs(ordersIndex: ordersIndex, of: string, index: index+1, visited: visited, count: count)
}
