//
//  BAEKJOON15659.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct BAEKJOON15659 {
    static var results: [Int] = []

    enum OperatorMenu: Int {
        case plus = 0
        case minus = 1
        case mul = 2
        case div = 3
        
        func getExpression() -> String {
            switch self {
            case .plus: return "+"
            case .minus: return "-"
            case .mul: return "*"
            case .div: return "/"
            }
        }
    }

    static func main() {
        guard let _ = Int(readLine() ?? "") else { return }
        guard let inputOperand = readLine()?.split(separator: " ").map(String.init) else { return }
        guard let inputOperator = readLine()?.split(separator: " ").map(String.init) else { return }
        
        let operands = inputOperand.map { Int($0)! }
        let operators = inputOperator.map { Int($0)! }
        
        dfs(operands: operands, operators: operators, currentExpression: [])
        
        results = results.sorted(by: <)
        if results.count == 1 {
            print(results[0])
            print(results[0])
        } else {
            print(results[results.count-1])
            print(results[0])
        }
    }

    static func dfs(operands: [Int], operators: [Int], currentExpression: [String]) {
        // 여기서 계산하는 로직 추가
        if operands.isEmpty {
            let result = calculator(makePostfix(currentExpression))
            results.append(result)
            return
        }
        
        var operands = operands
        var operators = operators
        var tempExpression: [String] = currentExpression
        
        if tempExpression.isEmpty { tempExpression.append("\(operands.removeFirst())") }
        let lastOperand = operands.removeFirst()
        
        if operators.isEmpty {
            tempExpression.append("\(lastOperand)")
            dfs(operands: operands, operators: operators, currentExpression: tempExpression)
        }
        
        for index in 0..<operators.count {
            if operators[index] == 0 { continue }
            guard let eachOperator = OperatorMenu(rawValue: index) else { return }
            operators[index] -= 1
            tempExpression.append("\(eachOperator.getExpression())")
            tempExpression.append("\(lastOperand)")
            dfs(operands: operands, operators: operators, currentExpression: tempExpression)
            operators[index] += 1
            tempExpression.removeLast()
            tempExpression.removeLast()
        }
    }

    static func makePostfix(_ experssion: [String]) -> [String] {
        var stack: [String] = []
        var result: [String] = []
        
        for each in experssion {
            if let operand = Int(each) { result.append("\(operand)") }
            else {
                if stack.isEmpty {
                    stack.append(each)
                    continue
                }
                
                if each == "+" || each == "-" {
                    result.append(stack.removeLast())
                    if !stack.isEmpty { result.append(stack.removeLast()) }
                    stack.append(each)
                } else {
                    if stack[stack.count-1] == "+" || stack[stack.count-1] == "-" { stack.append(each) }
                    else {
                        result.append(stack.removeLast())
                        stack.append(each)
                    }
                }
            }
        }
        for _ in 0..<stack.count { result.append(stack.removeLast()) }
        return result
    }

    static func calculator(_ expression: [String]) -> Int {
        var stack: [Int] = []
        
        for each in expression {
            if let operand = Int(each) { stack.append(operand) }
            else {
                let secondOperand = stack.removeLast()
                let firstOperand = stack.removeLast()
                if each == "+" { stack.append(firstOperand + secondOperand) }
                else if each == "-" { stack.append(firstOperand - secondOperand) }
                else if each == "*" { stack.append(firstOperand * secondOperand) }
                else { stack.append(firstOperand / secondOperand) }
            }
        }
        return stack.removeLast()
    }
}
