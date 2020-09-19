//
//  Problem.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/09/12.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

func solution(_ new_id:String) -> String {
    var new_id = new_id
    
    new_id = setFirstRegular(new_id)
    new_id = setSecondRegular(new_id)
    new_id = setThirdRegular(new_id)
    new_id = setFourthRegular(new_id)
    new_id = setFifthRegular(new_id)
    new_id = setSixthRegular(new_id)
    new_id = setSeventhRegular(new_id)
    
    return new_id
}

func setFirstRegular(_ id: String) -> String {
    return id.lowercased()
}

func setSecondRegular(_ id: String) -> String {
    var id = id
    let charaterSet: [Character] = ["-", "_", ".", "0", "1", "2",
                                    "3", "4", "5", "6", "7", "8",
                                    "9", "a", "b", "c", "d", "e",
                                    "f", "g", "h", "i", "j", "k",
                                    "l", "m", "n", "o", "p", "q",
                                    "r", "s", "t", "u", "v", "w",
                                    "y", "x", "y", "z"]
    
    for index in (0..<id.count).reversed() {
        let stringIndex = id.index(id.startIndex, offsetBy: index)
        if !charaterSet.contains(id[stringIndex]) { id.remove(at: stringIndex) }
    }
    return id
}

func setThirdRegular(_ id: String) -> String {
    var id = id
    var count: Int = 0
    var markingRemove: [Int] = []
    
    for index in 0..<id.count {
        let stringIndex = id.index(id.startIndex, offsetBy: index)
        
        // .을 찾은경우 Count 1씩 증가
        if id[stringIndex] == "." {
            count += 1
        } else {
            count = 0
            continue
        }
        
        if count >= 2 {
            markingRemove.append(index)
        }
    }
    
    for eachIndex in markingRemove.reversed() {
        let stringIndex = id.index(id.startIndex, offsetBy: eachIndex)
        id.remove(at: stringIndex)
    }
    return id
}

func setFourthRegular(_ id: String) -> String {
    var id = id
    if id.last == "." {
        id.removeLast()
    }
    
    if id.first == "." {
        id.removeFirst()
    }
    return id
}

func setFifthRegular(_ id: String) -> String {
    if id.isEmpty { return "a" }
    else { return id }
}

func setSixthRegular(_ id: String) -> String {
    var id = id
    if id.count >= 16 {
        for index in (15..<id.count).reversed() {
            let stringIndex = id.index(id.startIndex, offsetBy: index)
            id.remove(at: stringIndex)
        }
    }
    
    if id.last == "." { id.removeLast() }
    
    return id
}

func setSeventhRegular(_ id: String) -> String {
    var id = id
    var lastChar: Character?
    
    while id.count <= 2 {
        if lastChar == nil { lastChar = id.last }
    
        if let lastChar = lastChar { id.append(lastChar) }
    }
    return id
}
