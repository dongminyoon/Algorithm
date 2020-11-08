//
//  VisitLength.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/11/04.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct VisitLength {
    
}


struct CustomArray<T> {
    var arr: [T] = []
    
    func map<U>(transform: (T) -> U) -> [U] {
        var mapArr: [U] = []
        arr.forEach { each in
            mapArr.append(transform(each))
        }
        return mapArr
    }
}
