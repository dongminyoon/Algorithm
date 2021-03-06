//
//  NewerIDRecommend.swift
//  Algorithm
//
//  Created by USER on 2021/03/06.
//  Copyright © 2021 윤동민. All rights reserved.
//

import Foundation

struct NewerIDReccomend {
    func solution(_ new_id: String) -> String {
        return recommendID(from: new_id)
    }
    
    func recommendID(from new_id: String) -> String {
        var recommend_id: String = new_id
        recommend_id = regulateFirst(of: recommend_id)
        recommend_id = regulateSecond(of: recommend_id)
        recommend_id = regulateThird(of: recommend_id)
        recommend_id = regulateFourth(of: recommend_id)
        recommend_id = regulateFifth(of: recommend_id)
        recommend_id = regulateSixth(of: recommend_id)
        recommend_id = regulateSeventh(of: recommend_id)
        
        return recommend_id
    }
    
    func regulateFirst(of new_id: String) -> String {
        return new_id.lowercased()
    }
    
    func regulateSecond(of new_id: String) -> String {
        var validCharacterSet = CharacterSet.init([".", "-", "_"])
        validCharacterSet.formUnion(CharacterSet.alphanumerics)
        validCharacterSet.formUnion(CharacterSet.decimalDigits)
        
        return new_id.filter { element in
            validCharacterSet.isSuperset(of: CharacterSet.init(charactersIn: String(element)))
        }
    }
    
    func regulateThird(of new_id: String) -> String {
        var new_id: String = new_id
        
        var count: Int = 0
        
        new_id.enumerated().reversed().forEach { index, element in
            if element == "." {
                count += 1
                if index == 0 && count >= 2 {
                    (index+1..<index+count).reversed().forEach {
                        let strIndex = new_id.index(new_id.startIndex, offsetBy: $0)
                        new_id.remove(at: strIndex)
                    }
                }
            } else {
                if count >= 2 {
                    (index+1..<index+count).reversed().forEach {
                        let strIndex = new_id.index(new_id.startIndex, offsetBy: $0)
                        new_id.remove(at: strIndex)
                    }
                    count = 0
                    return
                } else { count = 0; return }
            }
        }
        return new_id
    }
    
    func regulateFourth(of new_id: String) -> String {
        var new_id = new_id
        if new_id.last  == "." { new_id.removeLast() }
        if new_id.first == "." { new_id.removeFirst() }
        return new_id
    }
    
    func regulateFifth(of new_id: String) -> String {
        return new_id.isEmpty ? "a" : new_id
    }
    
    func regulateSixth(of new_id: String) -> String {
        var new_id = new_id
        if new_id.count >= 16 {
            for index in (15..<new_id.count).reversed() {
                let strIndex = new_id.index(new_id.startIndex, offsetBy: index)
                new_id.remove(at: strIndex)
            }
            
            if new_id.last == "." { new_id.removeLast() }
        }
        return new_id
    }
    
    func regulateSeventh(of new_id: String) -> String {
        var new_id = new_id
        if new_id.count <= 2 {
            guard let lastChar = new_id.last else { return "" }
            while new_id.count < 3 { new_id += String(lastChar) }
        }
        
        return new_id
    }
}
