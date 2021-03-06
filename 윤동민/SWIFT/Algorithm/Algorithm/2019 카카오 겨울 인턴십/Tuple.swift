//
//  Tuple.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

struct Tuple {
    static func solution(_ s:String) -> [Int] {
        let tuplePattern = "\\{\\d+(,\\d+)*\\}"
        let matchTuples = extractTuple(s, tuplePattern).sorted { $0.endIndex < $1.endIndex }

        let digitPattern = "\\d+"
        var totalTuple: [Int] = []
        
        for tuple in matchTuples {
            let tupleToInt = extractTuple(tuple, digitPattern).map { Int($0)! }
            for each in tupleToInt {
                if !totalTuple.contains(each) { totalTuple.append(each) }
            }
        }
        return totalTuple
    }

    static func extractTuple(_ s: String, _ pattern: String) -> [String] {
        let regex = try? NSRegularExpression(pattern: pattern, options: [])
        guard let matchString = regex?.matches(in: s, options: [], range: NSRange(s.startIndex..., in: s)) else { return [] }
        return matchString.map { String(s[Range($0.range, in: s)!]) }
    }
}
