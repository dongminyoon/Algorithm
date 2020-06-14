//
//  FalilPercentage.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/13.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct FailPercentage {
    static func solution(_ N:Int, _ stages:[Int]) -> [Int] {
        var total_people_per_stage: [Int] = Array(repeating: 0, count: N+1)
        var total_people_per_stage_clear: [Int] = Array(repeating: 0, count: N+1)
        
        for each in stages {
            for index in 1...each {
                if index != N+1 { total_people_per_stage[index] += 1 }
                if index != each { total_people_per_stage_clear[index] += 1 }
            }
        }
        
        var perStage_Failure_Percentage: [Int: Float] = [:]
        for index in 1...N {
            if total_people_per_stage[index] == 0 {
                perStage_Failure_Percentage.updateValue(0, forKey: index)
                continue
            }
            let fail_People = total_people_per_stage[index] - total_people_per_stage_clear[index]
            perStage_Failure_Percentage.updateValue(Float(fail_People)/Float(total_people_per_stage[index]), forKey: index)
        }
        
        let sortingResult = perStage_Failure_Percentage.sorted {
            if $0.1 == $1.1 {
                return $0.0 < $1.0
            }
            return $0.1 > $1.1
        }
        
        var result: [Int] = []
        for each in sortingResult {
            result.append(each.key)
        }
        
        return result
    }
}
