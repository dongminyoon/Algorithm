//
//  MaxExpression.swift
//  Algorithm
//
//  Created by 윤동민 on 2021/01/31.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct MaxExpression {
    static func solution(_ expression:String) -> Int64 {
        var operSet = Set<String>()
        expression.filter { $0 == "+" || $0 == "-" || $0 == "*" }
                    .map { String($0) }
                    .forEach {
                        operSet.insert($0)
                    }
        
        var indexOper: [String] = []
        var visited: [Bool] = []
        
        operSet.forEach {
            indexOper.append($0)
            visited.append(false)
        }
        
        for index in 0..<indexOper.count {
            visited[index] = true
            dfs(indexOper, [indexOper[index]: 0], visited, expression)
            visited[index] = false
        }
        
        return 0
    }

    static func dfs(_ oper: [String], _ priority: [String: Int], _ visited: [Bool], _ expression: String) {
        if priority.count == oper.count {
            calculate(priority, expression)
            return
        }
        
        for t_index in 0..<oper.count {
            if visited[t_index] { continue }
            
            var priority = priority
            var visited = visited
            priority.updateValue(priority.count, forKey: oper[t_index])
            visited[t_index] = true
            
            dfs(oper, priority, visited, expression)
            
            priority.removeValue(forKey: oper[t_index])
            visited[t_index] = false
        }
    }

    static func calculate(_ priority: [String: Int], _ expression: String) {
        let sorted_priority = priority.sorted(by: { $0.value > $1.value })
        
        let numberOfExpression = expression.components(separatedBy: ["*", "+", "-"])
        let operatorOfExpression = expression.filter { $0 == "+" || $0 == "-" || $0 == "*" }.map { String($0) }
        
        var expressionOfArray: [String] = []
        
        var operator_hash: [String: [Int]] = [:]
        
        var index: Int = 0
        while index < operatorOfExpression.count {
            expressionOfArray.append(numberOfExpression[index])
            expressionOfArray.append(operatorOfExpression[index])
            
            let key = operatorOfExpression[index]
            if var indexes = operator_hash[key] {
                indexes.append(expressionOfArray.count-1)
                operator_hash.updateValue(indexes, forKey: key)
            } else {
                operator_hash.updateValue([expressionOfArray.count-1], forKey: key)
            }
            
            index += 1
        }
        
        expressionOfArray.append(numberOfExpression[index])
        
        sorted_priority.forEach {
            (key, _) in
            operator_hash[key]?.forEach {
                let operand2 = Int(expressionOfArray.remove(at: $0+1))!
                let _operator = expressionOfArray.remove(at: $0)
                let operand1 = Int(expressionOfArray.remove(at: $0-1))!

                let result = calculate(by: _operator, operand: [operand1, operand2])
                print(result)
            }
            
            
            print(expressionOfArray)
        }
    }

    static func calculate(by _operator: String, operand: [Int]) -> Int {
        if _operator == "+" {
            return operand[0] + operand[1]
        } else if _operator == "*" {
            return operand[0] * operand[1]
        } else {
            return operand[0] - operand[1]
        }
    }
}
