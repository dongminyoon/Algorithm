//
//  main.swift
//  2020KakaoBlindBlink
//
//  Created by 윤동민 on 2020/05/10.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

func solution(_ p:String) -> String {
    if p == "" { return p }
    
    
    return ""
}

func check(_ checked: String) -> Bool {
    var stack: [String] = []
    
    for index in 0..<checked.count {
        let stringIndex = checked.index(checked.startIndex, offsetBy: index)
        // "("가 들어오는 경우 Stack에 추가
        if checked[stringIndex] == "(" { stack.append(String(checked[stringIndex])) }
        else {
            if !stack.isEmpty { stack.removeLast() }
            else { return false }
        }
    }
    
    if stack.isEmpty { return true }
    else { return false }
}


solution("()))((()")
