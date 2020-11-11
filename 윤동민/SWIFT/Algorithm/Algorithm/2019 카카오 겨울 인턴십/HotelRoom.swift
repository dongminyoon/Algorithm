//
//  HotelRoom.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct HotelRoom {
    var dic: [Int64: Int64] = [:]

    mutating func solution(_ k:Int64, _ room_number:[Int64]) -> [Int64] {
        var answer: [Int64] = []
        
        room_number.forEach {
            room in
            answer.append(search(room))
        }
        
        return answer
    }

    mutating func search(_ room: Int64) -> Int64 {
        if dic[room] == nil {
            dic.updateValue(room+1, forKey: room)
            return room
        }
        
        var emptyRoom = search(dic[room]!)
        dic.updateValue(emptyRoom+1, forKey: room)
        return emptyRoom
    }
}
