//
//  Cache.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/10/29.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct AA {
    func solution(_ cacheSize:Int, _ cities:[String]) -> Int {
        var answer: Int = 0
        
        if cacheSize == 0 { return cities.count * 5 }
        
        var cache: [String] = []
        
        
        
        for city in cities {
            let lowerCity = city.lowercased()
            
            if cache.contains(lowerCity) {
                answer += 1
                cache.removeAll(where: { $0 == lowerCity })
                cache.append(lowerCity)
            } else {
                answer += 5
                if cache.count >= cacheSize {
                    cache.removeFirst()
                    cache.append(lowerCity)
                    continue
                }
                cache.append(lowerCity)
            }
        }
        
        return answer
    }
}
