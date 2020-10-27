//
//  SkillTree.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/10/27.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct SkillTree {
    var precede_Skill: String = ""

    mutating func solution(_ skill:String, _ skill_trees:[String]) -> Int {
        var answer: Int = 0
        precede_Skill = skill
        
        for each in skill_trees {
            if check(each) { answer += 1 }
        }
        
        return answer
    }

    func check(_ cur_Skill: String) -> Bool {
        var curOrder: Int = 0
        
        for index in 0..<cur_Skill.count {
            let stringIndex = cur_Skill.index(cur_Skill.startIndex, offsetBy: index)
            if precede_Skill.contains(cur_Skill[stringIndex]) {
                let skillTreeIndex = precede_Skill.index(precede_Skill.startIndex, offsetBy: curOrder)
                if precede_Skill[skillTreeIndex] == cur_Skill[stringIndex] {
                    curOrder += 1
                } else {
                    return false
                }
            }
            
            if curOrder == precede_Skill.count { return true }
        }
        
        return true
    }
    
    
}
