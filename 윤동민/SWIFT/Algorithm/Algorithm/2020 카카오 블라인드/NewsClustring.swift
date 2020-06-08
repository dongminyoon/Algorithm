//
//  NewsClustring.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct NewsClustring {
    static func solution(_ str1:String, _ str2:String) -> Int {
        let splitedString1 = splitString(str1)
        let splitedString2 = splitString(str2)
        
        let intersection = searchIntersection(splitedString1, splitedString2)
        let union = searchUnion(splitedString1, splitedString2)
        
        if intersection.count == 0 && union.count == 0 { return 65536 }
        let proportion = Float(intersection.count) / Float(union.count)
        
        return Int(proportion * 65536)
    }


    static func splitString(_ str: String) -> [String] {
        var splitedStrings: [String] = []
        for index in 0..<str.count-1 {
            let stringFirstIndex = str.index(str.startIndex, offsetBy: index)
            let stringLastIndex = str.index(str.startIndex, offsetBy: index+1)
            let splitString = String(str[stringFirstIndex...stringLastIndex])
            if isCharacter(at: splitString) == 0 { continue }
            splitedStrings.append(splitString)
        }
        return splitedStrings
    }

    static func isCharacter(at str: String) -> Int {
        let pattern = "([a-z]|[A-Z])([a-z]|[A-Z])"
        let regex = try? NSRegularExpression(pattern: pattern, options: [])
        let n = regex?.numberOfMatches(in: str, options: [], range: NSRange(str.startIndex..., in: str))
        return n!
    }

    static func searchIntersection(_ splitedString1: [String], _ splitedString2: [String]) -> [String] {
        var visited: [Bool] = Array(repeating: false, count: splitedString2.count)
        var intersection: [String] = []
        
        for each in splitedString1 {
            for index in 0..<splitedString2.count {
                if each.uppercased() == splitedString2[index].uppercased() && !visited[index] {
                    intersection.append(each)
                    visited[index] = true
                    break
                }
            }
        }
        return intersection
    }

    static func searchUnion(_ splitedString1: [String], _ splitedString2: [String]) -> [String] {
        var visited: [Bool] = Array(repeating: false, count: splitedString2.count)
        var union: [String] = []
        
        for each in splitedString1 {
            for index in 0..<splitedString2.count {
                if each.uppercased() == splitedString2[index].uppercased() && !visited[index] {
                    visited[index] = true
                    break
                }
            }
        }
        
        for each in splitedString1 { union.append(each) }
        for index in 0..<splitedString2.count {
            if !visited[index] { union.append(splitedString2[index]) }
        }
        
        return union
    }
}
