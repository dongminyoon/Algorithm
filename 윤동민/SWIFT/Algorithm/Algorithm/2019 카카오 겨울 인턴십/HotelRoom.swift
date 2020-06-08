//
//  HotelRoom.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct HotelRoom {
    static var nextRoom: [Int64: Int64] = [:]

    static func solution(_ k:Int64, _ room_number:[Int64]) -> [Int64] {
        var set_Room_Number: [Int64] = []
        
        for want_Number in room_number {
            if nextRoom[want_Number] == nil {
                set_Room_Number.append(want_Number)
                nextRoom.updateValue(findNextRoom(roomNumber: want_Number+1), forKey: want_Number)
            } else {
                let searchRoom = findNextRoom(roomNumber: want_Number)
                set_Room_Number.append(searchRoom)
                nextRoom.updateValue(searchRoom+1, forKey: searchRoom)
            }
        }
        
        return set_Room_Number
    }

    static func findNextRoom(roomNumber: Int64) -> Int64 {
        if nextRoom[roomNumber] == nil {
            return roomNumber
        } else {
            let availableRoom = findNextRoom(roomNumber: roomNumber+1)
            return availableRoom
        }
    }

}
