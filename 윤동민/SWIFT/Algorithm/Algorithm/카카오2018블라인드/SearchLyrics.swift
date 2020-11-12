//
//  SearchLyrics.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/11/10.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct SearchLyrics {
    static func solution(_ words: [String], _ queries: [String]) -> [Int] {
        var dic: [Int: Trie] = [:]
        var reverseDic: [Int: Trie] = [:]
        
        words.forEach { word in
            if dic[word.count] == nil {
                dic[word.count] = Trie()
                
                reverseDic[word.count] = Trie()
            }
            
            dic[word.count]?.insert(word)
            reverseDic[word.count]?.insert(String(word.reversed()))
        }
        
        var answer: [Int] = []
        queries.forEach { query in
            if query[query.startIndex] == "?" {
                // 접두사에 있는 경우 뒤에서부터 탐색해야함 => reverseDic 활용
                if let reverseTrie = reverseDic[query.count] {
                    let reverseQuery = String(query.reversed())
                    answer.append(reverseTrie.search(reverseQuery))
                } else {
                    answer.append(0)
                }
            } else {
                if let trie = dic[query.count] {
                    answer.append(trie.search(query))
                } else {
                    answer.append(0)
                }
            }
        }
        
        return answer
    }
}

class Trie {
    var root: Nodes
    
    init() {
        root = Nodes(value: "")
    }
    
    func insert(_ word: String) {
        var curNode = root
        for index in 0..<word.count {
            curNode.count += 1
            let character = String(word[word.index(word.startIndex, offsetBy: index)])
            if curNode.child[character] == nil {
                curNode.child[character] = Nodes(value: character)
            }
            
            curNode = curNode.child[character]!
        }
    }
    
    func search(_ query: String) -> Int {
        if query.isEmpty { return 0 }
        
        var curNode = root
        for index in 0..<query.count {
            let character = String(query[query.index(query.startIndex, offsetBy: index)])
            
            if character == "?" { return curNode.count }
            if curNode.child[character] == nil { return 0 }
            
            curNode = curNode.child[character]!
        }
        
        return curNode.count
    }
}

class Nodes {
    var value: String
    var count: Int
    var child: [String: Nodes]
    
    var isEmpry: Bool {
        return child.isEmpty
    }
    
    init(value: String) {
        self.value = value
        count = 0
        child = [:]
    }
}


//class Trie {
//    var root: [String: Nodes]
//    var count: Int = 0
//
//    init() {
//        root = [:]
//    }
//
//    func insert(_ word: String) {
//        count += 1
//        var character = String(word[word.startIndex])
//        if root[character] == nil { root[character] = Nodes(value: character) }
//
//        var curNode = root[character]!
//        curNode.count += 1
//        for index in 1..<word.count {
//            character = String(word[word.index(word.startIndex, offsetBy: index)])
//
//            if curNode.child[character] == nil { curNode.child[character] = Nodes(value: character) }
//            curNode = curNode.child[character]!
//            curNode.count += 1
//        }
//    }
//
//    func search(_ word: String) -> Int {
//        var character: String = String(word[word.startIndex])
//        if character == "?" { return count }
//        guard var curNode = root[character] else { return 0 }
//
//        for index in 1..<word.count {
//            character = String(word[word.index(word.startIndex, offsetBy: index)])
//            if character == "?" { return curNode.count }
//
//            if curNode.child[character] == nil { return 0 }
//            curNode = curNode.child[character]!
//        }
//
//        return curNode.count
//    }
//
//}
