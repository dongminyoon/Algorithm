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
    
    check(p)
    return ""
}

func check(_ checked: String) -> Bool {
    var stack: [String] = []
    
    for index in 0..<checked.count {
        let stringIndex = checked.index(checked.startIndex, offsetBy: index)
        if checked[stringIndex] == "(" { stack.append(String(checked[stringIndex])) }
    }
    
    print(stack)
    return true
}


solution("(()())()")
