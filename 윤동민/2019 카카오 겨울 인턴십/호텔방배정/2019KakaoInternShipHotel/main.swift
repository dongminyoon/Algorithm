//
//  main.swift
//  2019KakaoInternShipHotel
//
//  Created by 윤동민 on 2020/05/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var nextRoom: [Int64: Int64] = [:]

func solution(_ k:Int64, _ room_number:[Int64]) -> [Int64] {
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

func findNextRoom(roomNumber: Int64) -> Int64 {
    if nextRoom[roomNumber] == nil {
        return roomNumber
    } else {
        let availableRoom = findNextRoom(roomNumber: roomNumber+1)
        return availableRoom
    }
}


print(solution(10, [1,3,4,1,3,1]))

