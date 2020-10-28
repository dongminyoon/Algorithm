//
//  QuickSort.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/10/28.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct QuickSort {
    var array: [Int]
    
    mutating func partition(left: Int, right: Int) -> Int {
        let pivot = array[left]
        
        var i = left, j = right
        
        while i < j {
            while pivot < array[j] && j >= 0 { j -= 1 }
            while pivot >= array[i] && i < j { i += 1 }
                    
            let temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
        
        array[left] = array[i]
        array[i] = pivot
        
        return i
    }

    mutating func quicksort(left: Int, right: Int) {
        guard left < right else { return }
        let pivot = partition(left: left, right: right)
        
        quicksort(left: left, right: pivot-1)
        quicksort(left: pivot+1, right: right)
    }
}
