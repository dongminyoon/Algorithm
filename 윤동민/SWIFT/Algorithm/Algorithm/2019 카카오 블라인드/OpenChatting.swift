//
//  OpenChatting.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/12.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct OpenChatting {
    static func solution(_ record:[String]) -> [String] {
        
        var id_nickname: [String: String] = [:]
        var result: [String] = []
        
        for index in 0...record.count-1 {
            let eachRecord = record[index].split(separator: " ").map(String.init)
            if eachRecord[0] == "Enter" {
                id_nickname.updateValue(eachRecord[2], forKey: eachRecord[1])
                result.append("\(eachRecord[1])님이 들어왔습니다.")
            } else if eachRecord[0] == "Change" {
                id_nickname.updateValue(eachRecord[2], forKey: eachRecord[1])
            } else {
                result.append("\(eachRecord[1])님이 나갔습니다.")
            }
        }
        
        for index in 0...result.count-1 {
            
            let lastIndex = result[index].firstIndex(of: "님")!
            let firstIndex = result[index].startIndex
            let id_Partition = String(result[index][firstIndex..<lastIndex])
            let tempResult = result[index]
            result[index] = tempResult.replacingOccurrences(of: id_Partition, with: id_nickname[id_Partition]!)
        }
        
        return result
    }
}
