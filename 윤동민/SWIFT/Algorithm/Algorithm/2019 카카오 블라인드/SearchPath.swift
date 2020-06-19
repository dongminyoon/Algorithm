//
//  SearchPath.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/19.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

class Node {
    var number: Int
    var position: [Int]
    weak var leftNode: Node?
    weak var rightNode: Node?
    
    init(number: Int, position: [Int]) {
        self.number = number
        self.position = position
    }
}

struct SearchPath {
    static func solution(_ nodeinfo:[[Int]]) -> [[Int]] {
        var sorted_Node: [Node] = []
        for index in 0...nodeinfo.count-1 {
            let node = Node(number: index+1, position: nodeinfo[index])
            sorted_Node.append(node)
        }
                
        sorted_Node = sorted_Node.sorted { firstNode, secondNode in
            firstNode.position[1] > secondNode.position[1]
        }
        
        sorted_Node = sorted_Node.sorted { firstNode, secondNode in
            firstNode.position[1] == secondNode.position[1] && firstNode.position[0] < secondNode.position[0]
        }
        
        setChild(nodes: sorted_Node)
        preFix(node: sorted_Node.first!)
        postFix(node: sorted_Node.first!)
        
        return [preFixOrder, postFixOrder]
    }
    
    static func setChild(nodes: [Node]) {
        var nodes = nodes
        let root = nodes.removeFirst()
        
        nodes.forEach { node in
            dfs(parentNode: root, childNode: node)
        }
    }

    
    static func dfs(parentNode: Node, childNode: Node) {
        if parentNode.position[0] > childNode.position[0] {
            if let leftNode = parentNode.leftNode {
                dfs(parentNode: leftNode, childNode: childNode)
            } else {
                parentNode.leftNode = childNode
            }
        } else {
            if let rightNode = parentNode.rightNode {
                dfs(parentNode: rightNode, childNode: childNode)
            } else {
                parentNode.rightNode = childNode
            }
        }
    }
    
    static var preFixOrder: [Int] = []
    
    static func preFix(node: Node) {
        preFixOrder.append(node.number)
        if let leftChild = node.leftNode { preFix(node: leftChild) }
        if let rightChild = node.rightNode { preFix(node: rightChild) }
    }
    
    static var postFixOrder: [Int] = []
    
    static func postFix(node: Node) {
        if let leftChild = node.leftNode { postFix(node: leftChild) }
        if let rightChild = node.rightNode { postFix(node: rightChild) }
        postFixOrder.append(node.number)
    }
}
