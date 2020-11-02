//
//  EnglishEnding.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/11/02.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct EnglishEnding {
    func solution(_ n:Int, _ words:[String]) -> [Int] {
        var dic: [Int: Int] = [:]
        var isUseWord: [String] = []
        
        (1...n).forEach {
            number in
            dic.updateValue(0, forKey: number)
        }
        
        var index: Int = 0
        var preChar: String = ""
        while index < words.count {
            guard let curTurn = dic[(index%n)+1] else { return [] }
            dic.updateValue(curTurn+1, forKey: (index%n)+1)
            
            if index != 0 {
                if String(words[index][words[index].startIndex]) != preChar {
                    return [(index%n)+1, curTurn+1]
                }
            }
            
            if isUseWord.contains(words[index]) {
                return [(index%n)+1, curTurn+1]
            } else {
                isUseWord.append(words[index])
            }
            
            let lastIndex = words[index].index(words[index].startIndex, offsetBy: words[index].count-1)
            preChar = String(words[index][lastIndex])
            index += 1
        }
        
        return [0, 0]
    }
}
