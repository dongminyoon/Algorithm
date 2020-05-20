//
//  main.swift
//  BAEKJOON15659
//
//  Created by 윤동민 on 2020/05/20.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var results: [Int] = []

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

func main() {
    guard let _ = Int(readLine() ?? "") else { return }
    guard let inputOperand = readLine()?.split(separator: " ").map(String.init) else { return }
    guard let inputOperator = readLine()?.split(separator: " ").map(String.init) else { return }
    
    let operands = inputOperand.map { Int($0)! }
    let operators = inputOperator.map { Int($0)! }
    
    dfs(operands: operands, operators: operators, currentExpression: [])
}

func dfs(operands: [Int], operators: [Int], currentExpression: [String]) {
    // 여기서 계산하는 로직 추가
    if operands.isEmpty {
        calculator(currentExpression)
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

func calculator(_ experssion: [String]) -> Int {
    var stack: [String] = []
    var result: [String] = []
    
    
    // 이 부분을 아예 수정해야한다.
    for each in experssion {
        if let operand = Int(each) { result.append("\(operand)") }
        else {
            if each == "+" || each == "-" { stack.append(each) }
            else { result.append(each) }
        }
    }
    
    for each in (0..<stack.count).reversed() {
        
    }
    for each in stack { result.append(each) }
    
    print(result)
    
    var calculatorStack: [Int] = []
    for each in result {
        
    }
    
    return 10
}

main()

