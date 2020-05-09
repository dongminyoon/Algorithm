//
//  main.swift
//  BAEKJOON2309
//
//  Created by 윤동민 on 2020/05/09.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

func main() {
    var heights: [Int] = []
    var sum: Int = 0
    var isSuccess: Bool = false
    
    for _ in 1...9 {
        guard let input = readLine() else { return }
        guard let height = Int(input) else { return }
        heights.append(height)
        sum += height
    }
    
    for indexI in 0...7 {
        for indexJ in indexI+1...8 {
            if (sum - heights[indexI] - heights[indexJ] == 100) {
                heights.remove(at: indexI)
                heights.remove(at: indexJ-1)
                isSuccess = true
                break
            }
        }
        if isSuccess { break }
    }
    
    heights = heights.sorted(by: <)
    for index in 0...6 { print(heights[index]) }
}


main()
