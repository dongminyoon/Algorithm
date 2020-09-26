//
//  KeyPad.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/09/27.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct KeyPad {
    struct Position {
        var x: Int
        var y: Int
    }
    
    static func solution(_ numbers: [Int], _ hand: String) -> String {
        var leftHandPosition = Position(x: 0, y: 3)
        var rightHandPosition = Position(x: 2, y: 3)
    
        var result: String = ""
        
        numbers.forEach { number in
            if number == 1 || number == 4 || number == 7 {
                leftHandPosition.x = 0
                if number == 1 { leftHandPosition.y = 0 }
                else if number == 4 { leftHandPosition.y = 1 }
                else { leftHandPosition.y = 2 }
                result += "L"
            } else if number == 3 || number == 6 || number == 9 {
                rightHandPosition.x = 2
                if number == 3 { rightHandPosition.y = 0 }
                else if number == 6 { rightHandPosition.y = 1 }
                else { rightHandPosition.y = 2 }
                result += "R"
            } else {
                if close(leftHandPosition, rightHandPosition, key: number, hand: hand) {
                    leftHandPosition.x = 1
                    if number == 2 { leftHandPosition.y = 0 }
                    else if number == 5 { leftHandPosition.y = 1 }
                    else if number == 8 { leftHandPosition.y = 2 }
                    else { leftHandPosition.y = 3 }
                    result += "L"
                } else {
                    rightHandPosition.x = 1
                    if number == 2 { rightHandPosition.y = 0 }
                    else if number == 5 { rightHandPosition.y = 1 }
                    else if number == 8 { rightHandPosition.y = 2 }
                    else { rightHandPosition.y = 3 }
                    result += "R"
                }
            }
        }
        return result
    }
    
    // False ==> 오른손이 더 까가운 경우
    // True ==> 왼손이 더 가까운 경우
    static func close(_ leftHandPosition: Position, _ rightHandPosition: Position, key: Int, hand: String) -> Bool {
        var distanceLeft: Int = 0
        var distanceRight: Int = 0
        
        if key == 2 {
            distanceLeft = abs(leftHandPosition.y - 0) + abs(leftHandPosition.x - 1)
            distanceRight = abs(rightHandPosition.y - 0) + abs(rightHandPosition.x - 1)
        } else if key == 5 {
            distanceLeft = abs(leftHandPosition.y - 1) + abs(leftHandPosition.x - 1)
            distanceRight = abs(rightHandPosition.y - 1) + abs(rightHandPosition.x - 1)
        } else if key == 8 {
            distanceLeft = abs(leftHandPosition.y - 2) + abs(leftHandPosition.x - 1)
            distanceRight = abs(rightHandPosition.y - 2) + abs(rightHandPosition.x - 1)
        } else {
            distanceLeft = abs(leftHandPosition.y - 3) + abs(leftHandPosition.x - 1)
            distanceRight = abs(rightHandPosition.y - 3) + abs(rightHandPosition.x - 1)
        }
        
        if distanceLeft > distanceRight { return false }
        else if distanceLeft < distanceRight { return true }
        else {
            if hand == "right" { return false }
            else { return true }
        }
    }
}
