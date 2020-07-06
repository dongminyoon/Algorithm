//
//  BoostCamp.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/07/06.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

//extension String {
//    func isMatch(pattern: String) -> Bool {
//        let regex = try? NSRegularExpression(pattern : pattern, options: [])
//
//        let n = regex?.numberOfMatches(in: self, options: [], range: NSRange(self.startIndex..., in: self))
//        if n == 0 { return false }
//        else { return true }
//    }
//}
//
//func solution(_ name_list: [String]) -> Bool {
//    for indexI in 0..<name_list.count {
//        let firstString = name_list[indexI]
//        for indexJ in 0..<name_list.count {
//            if indexI == indexJ { continue }
//            if firstString.isMatch(pattern: name_list[indexJ]) { return true }
//        }
//    }
//    return false
//}

struct BootCamp {
    static func solution(_ arrayA:[Int], _ arrayB:[Int]) -> [Int] {
        var notDuplArrayA: [Int] = []
        arrayA.forEach { element in
            if !notDuplArrayA.contains(element) { notDuplArrayA.append(element) }
        }
        
        var notDuplArrayB: [Int] = []
        arrayB.forEach { element in
            if !notDuplArrayB.contains(element) { notDuplArrayB.append(element) }
        }
        
        let sumArray = sum(base: notDuplArrayA, other: notDuplArrayB)
        
        let comArray = complement(base: notDuplArrayA, other: notDuplArrayB)
        
        let interArray = intersect(base: notDuplArrayA, other: notDuplArrayB)
        
        
        return [notDuplArrayA.count, notDuplArrayB.count, sumArray.count, comArray.count, interArray.count]
    }

    static func sum(base: [Int], other: [Int]) -> [Int] {
        var sumArray: [Int] = []
        base.forEach { element in
            sumArray.append(element)
        }
        
        other.forEach { element in
            if !sumArray.contains(element) { sumArray.append(element) }
        }
        
        return sumArray
    }

    static func complement(base: [Int], other: [Int]) -> [Int] {
        var complementArray: [Int] = []
        var isContain: [Bool] = Array(repeating: false, count: base.count)
        
        for indexI in 0..<base.count {
            for indexJ in 0..<other.count {
                if base[indexI] == other[indexJ] {
                    isContain[indexI] = true
                    break
                }
            }
        }
        
        for indexI in 0..<base.count {
            if !isContain[indexI] { complementArray.append(base[indexI]) }
        }
        return complementArray
    }

    static func intersect(base: [Int], other: [Int]) -> [Int] {
        var intersectArray: [Int] = []
        var isContain: [Bool] = Array(repeating: false, count: base.count)
        
        for indexI in 0..<base.count {
            for indexJ in 0..<other.count {
                if base[indexI] == other[indexJ] {
                    isContain[indexI] = true
                    break
                }
            }
        }
        
        for indexI in 0..<base.count {
            if isContain[indexI] { intersectArray.append(base[indexI]) }
        }
        
        return intersectArray
    }
}
