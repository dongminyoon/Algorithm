//
//  3Probl.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/09/12.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation


struct Applicant {
    let language: Language
    let duty: Duty
    let career: Career
    let soulFood: SoulFood
    let point: Int
}

enum Language: String {
    case java = "java"
    case python = "python"
    case cpp = "cpp"
}

enum Duty: String {
    case backend = "backend"
    case frontend = "frontend"
}

enum Career: String {
    case junior = "junior"
    case senior = "senior"
}

enum SoulFood: String {
    case chiken = "chicken"
    case pizza = "pizza"
}

func solution(_ info:[String], _ query:[String]) -> [Int] {
    var applicantList: [Applicant] = []
    
    info.forEach { eachInfo in
        let splitInfo = eachInfo.split(separator: " ").map(String.init)
        
        guard let language = Language(rawValue: splitInfo[0]),
            let duty = Duty(rawValue: splitInfo[1]),
            let career = Career(rawValue: splitInfo[2]),
            let food = SoulFood(rawValue: splitInfo[3]),
            let point = Int(splitInfo[4]) else { return }
        
        
        let applicant = Applicant(language: language, duty: duty, career: career, soulFood: food, point: point)
        applicantList.append(applicant)
    }
    
    var result: [Int] = []
    
    query.forEach { eachQuery in
        var splitQuery = eachQuery.components(separatedBy: " and ")
        splitQuery += splitQuery.removeLast().split(separator: " ").map(String.init)
        
        var tempApplicantList = applicantList
        
        if let filterLanguage = Language(rawValue: splitQuery[0]) {
            tempApplicantList = tempApplicantList.filter { $0.language == filterLanguage }
        }
        
        if let filterDuty = Duty(rawValue: splitQuery[1]) {
            tempApplicantList = tempApplicantList.filter{ $0.duty == filterDuty }
        }
        
        if let filterCareer = Career(rawValue: splitQuery[2]) {
            tempApplicantList = tempApplicantList.filter { $0.career == filterCareer }
        }
        
        if let filterFood = SoulFood(rawValue: splitQuery[3]) {
            tempApplicantList = tempApplicantList.filter { $0.soulFood == filterFood }
        }
        
        guard let point = Int(splitQuery[4]) else { return }
        tempApplicantList = tempApplicantList.filter {
            return $0.point >= point
        }
        
        result.append(tempApplicantList.count)
    }
    
    
    print(result)
    return result
}
