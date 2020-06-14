//
//  CandidateKey.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/14.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct CandidateKey {
    static var candidateKeys: [[Int]] = []
    static var database: [[String]] = []
    
    static func solution(_ relation:[[String]]) -> Int {
        let colCount = relation[0].count
        database = relation
        
        for keyCount in 1...colCount {
            dfs(keyCount, 0, colCount, [])
        }
        return candidateKeys.count
    }
    
    
    // Key의 개수가 될 수 있는 수
    static func dfs(_ keyCount: Int, _ currentKey: Int, _ colCount: Int, _ key: [Int]) {
        if key.count == keyCount {
            // Key가 개수만큼 만들어 졌을 때
            // 최소키 검사, 유효성 검사 실행
            if !isMinimal(key) { return }
            if !isUnique(key) { return }
            
            candidateKeys.append(key)
            return
        }
        
        if currentKey >= colCount { return }
        
        var key = key
        dfs(keyCount, currentKey+1, colCount, key)
        
        key.append(currentKey)
        dfs(keyCount, currentKey+1, colCount, key)
    }
    
    // 이전 Key와 비교해서 최소성이 만족되지 않으면 false 리턴
    static func isMinimal(_ key: [Int]) -> Bool {
        for candidateKey in candidateKeys {
            if key.count <= candidateKey.count { continue }
            if isSubset(candidateKey, key) { return false }
        }
        return true
    }
    
    // smallSet이 bitSet의 부분 집합이면 True 출력
    static func isSubset(_ smallSet: [Int], _ bigSet: [Int]) -> Bool {
        var visited: [Bool] = Array(repeating: false, count: smallSet.count)
        
        for index_bigset in 0...bigSet.count-1 {
            for index_smallset in 0...smallSet.count-1 {
                if smallSet[index_smallset] == bigSet[index_bigset] { visited[index_smallset] = true }
            }
        }
        
        for each in visited {
            if each == false { return false }
        }
        
        return true
    }
        

    
    static func isUnique(_ key: [Int]) -> Bool {
        var tuples: [[String]] = []
        for indexRow in 0..<database.count {
            var tuple: [String] = []
            for eachKey in key {
                tuple.append(database[indexRow][eachKey])
            }
            tuples.append(tuple)
        }
        
        for indexI in 0..<tuples.count-1 {
            for indexJ in indexI+1..<tuples.count {
                if tuples[indexI] == tuples[indexJ] { return false }
            }
        }
        return true
    }
}
