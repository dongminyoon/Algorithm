//
//  CopyMap.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/10/29.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct CopyMap<E> {
    var array: [E]
    
    mutating func map<U>(transform: (E) -> U) -> [U] {
        var mapArr: [U] = []
        for index in 0..<array.count {
            mapArr.append(transform(array[index]))
        }
        
        var aa: String = "aa"
        
        aa.lowercased()
        
        return mapArr
    }
}
