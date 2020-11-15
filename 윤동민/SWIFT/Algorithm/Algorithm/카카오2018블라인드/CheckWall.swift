//
//  CheckWall.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/11/15.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct CheckWall {
    static var dist_count: Int = 0
    static var static_dist: [Int] = []
    static var static_weak: [Int] = []
    
    static var answer: Int = 0
    
    static func solution(_ n:Int, _ weak:[Int], _ dist:[Int]) -> Int {
        dist_count = dist.count
        static_dist = dist
        static_weak = weak
        static_dist.sort(by: <)
        
        dfs(0, [])
        
        return 0
    }
    
    // 모든 순서쌍을 찾는 완전 탐색
    static func dfs(_ index: Int, _ dist: [Int]) {
        if index == dist_count {
            if dist.isEmpty { return }
            isSatisfied(dist: dist)
            return
        }
        
        dfs(index+1, dist)
        var dist = dist
        dist.append(static_dist[index])
        dfs(index+1, dist)
    }
    
    static func isSatisfied(dist: [Int]) {
        dfsSatis(0, 0, [], dist)
    }
    
    static func dfsSatis(_ index: Int, _ count: Int, _ weak: [Int], _ dist: [Int]) {
        if count == dist.count {
            
            
            
            return
        }
        
        if index == static_weak.count { return }
        
        dfsSatis(index+1, count, weak, dist)
        var weak = weak
        weak.append(static_weak[index])
        dfsSatis(index+1, count+1, weak, dist)
    }
}
