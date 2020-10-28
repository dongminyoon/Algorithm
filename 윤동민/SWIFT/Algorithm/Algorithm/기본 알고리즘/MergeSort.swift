//
//  MergeSort.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/10/29.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct MergeSort {
    var array: [Int]
    
    mutating func merge(_ left: Int, _ right: Int) {
        guard left < right else { return }
        let middle = (left+right)/2
        
        merge(left, middle)
        merge(middle+1, right)
        mergeSort(left, middle, right)
    }
    
    mutating func mergeSort(_ left: Int, _ middle: Int, _ right: Int) {
        var i = left, j = middle+1, k = left
        var copyArr: [Int] = array
        
        while i <= middle && j <= right {
            if array[i] <= array[j] {
                copyArr[k] = array[i]
                i += 1
                k += 1
            } else {
                copyArr[k] = array[j]
                j += 1
                k += 1
            }
        }
        
        while i <= middle {
            copyArr[k] = array[i]
            i += 1
            k += 1
        }
        
        while j <= right {
            copyArr[k] = array[j]
            j += 1
            k += 1
        }
        
        for index in left...right { array[index] = copyArr[index] }
    }
}
