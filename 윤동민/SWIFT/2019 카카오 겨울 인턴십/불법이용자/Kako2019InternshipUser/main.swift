//
//  main.swift
//  Kako2019InternshipUser
//
//  Created by 윤동민 on 2020/05/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var visit: [String: [Bool]] = [:]

func solution(_ user_id:[String], _ banned_id:[String]) -> Int {
    var possible_banned_list: [String: [String]] = [:]
    
    for each_banned_id in banned_id {
        possible_banned_list.updateValue(check(each_banned_id, user_id), forKey: each_banned_id)
    }
    
    for (key, value) in possible_banned_list {
        visit.updateValue([], forKey: key)
        for _ in 0...value.count-1 { visit[key]?.append(false) }
    }
    
    print(possible_banned_list)
    
    dfs(possible_banned_list: possible_banned_list, combination: [])
    
    print(count)
    return 0
}

func check(_ each_banned_id: String, _ user_ids: [String]) -> [String] {
    var possible_banned_list: [String] = []
    
    for user_id in user_ids {
        if each_banned_id.count != user_id.count { continue }
        for offset in 0...each_banned_id.count-1 {
            let stringIndex = each_banned_id.index(each_banned_id.startIndex, offsetBy: offset)
            if offset == each_banned_id.count - 1 &&
                (each_banned_id[stringIndex] == "*" || each_banned_id[stringIndex] == user_id[stringIndex]) {
                possible_banned_list.append(user_id)
                break
            }
            
            if each_banned_id[stringIndex] == "*" { continue }
            else if each_banned_id[stringIndex] == user_id[stringIndex] { continue }
            else { break }
        }
    }
    
    return possible_banned_list
}

var count: Int = 0

func dfs(possible_banned_list: [String: [String]], combination: [String]) {
    var combination = combination
    
    
}


solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "abc1**"])
