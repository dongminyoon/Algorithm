//
//  main.swift
//  BAEKJOON1759
//
//  Created by 윤동민 on 2020/05/09.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var staticPasswordSet: [String] = []
var passwordSize: Int = 0
var listSize: Int = 0

var possiblePasswordSet: [[String]] = []

func main() {
    guard let input = readLine()?.split(separator: " ").map(String.init) else { return }
    guard let l = Int(input[0]) else { return }
    guard let c = Int(input[1]) else { return }
    
    var passwordSet: [String] = []
    guard let secondInput = readLine()?.split(separator: " ").map(String.init) else { return }
    for index in 0..<c { passwordSet.append(secondInput[index]) }
    
    staticPasswordSet = passwordSet.sorted(by: <)
    passwordSize = l
    listSize = c
    
    for index in 0..<listSize {
        dfs(currentIndex: index, set: [staticPasswordSet[index]])
    }
    
    for indexI in 0...possiblePasswordSet.count-1 {
        for indexJ in 0...possiblePasswordSet[indexI].count-1 {
            print("\(possiblePasswordSet[indexI][indexJ])", terminator: "")
        }
        print("")
    }
}

func dfs(currentIndex: Int, set: [String]) {
    var set = set
    if set.count == passwordSize && check(set) {
        possiblePasswordSet.append(set)
        return
    }
    
    for index in currentIndex+1..<listSize {
        set.append(staticPasswordSet[index])
        dfs(currentIndex: index, set: set)
        set.removeLast()
    }
}

func check(_ set: [String]) -> Bool {
    var moCount: Int = 0
    var jaCount: Int = 0
    for eachCharacter in set {
        if eachCharacter == "a" || eachCharacter == "e" || eachCharacter == "i"
            || eachCharacter == "o" || eachCharacter == "u" { moCount += 1 }
        else { jaCount += 1 }
    }
    
    if moCount >= 1 && jaCount >= 2 { return true }
    else { return false }
}

main()

