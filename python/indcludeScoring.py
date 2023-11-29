# This is intended to be a solution to problem "Include Scoring" on open.kattis.com


import sys
import math

table = {
    1:100,
    2:75,
    3:60,
    4:50,
    5:45,
    6:40,
    7:36,
    8:32,
    9:29,
    10:26,
    11:24,
    12:22,
    13:20,
    14:18,
    15:16,
    16:15,
    17:14,
    18:13,
    19:12,
    20:11,
    21:10,
    22:9,
    23:8,
    24:7,
    25:6,
    26:5,
    27:4,
    28:3,
    29:2,
    30:1
}

class Score:
    def __init__(self, solved, time_penalty, last_time, on_site):
        self.solved = solved
        self.time_penalty = time_penalty
        self.last_time = last_time
        self.on_site = on_site

        self.score = on_site


    def __lessthan__(self, second):
        if self.solved == second.solved:
            if self.time_penalty == second.time_penalty:
                return self.last_time < second.last_time
            return self.time_penalty < second.time_penalty
        return self.solved > second.solved

    def __equals__(self, second):
        return self.solved == second.solved and self.time_penalty == second.time_penalty and self.last_time == second.last_time

    def __stringrepr__(self) -> str:
        return f"Score({self.solved}, {self.time_penalty}, {self.last_time}, {self.on_site})"


def includedscoring(lines):
    scores = []
    for i in range(1, len(lines)):
        line = lines[i]
        nums = [int(x) for x in line.split()]
        scores.append(Score(*nums))

    correct_scores = []
    for score in scores:
        correct_scores.append(score)
    correct_scores = sorted(correct_scores)


    i = 0

    while i < len(correct_scores):
        current = correct_scores[i]
        current_index = i
        equal_scores = [correct_scores[i]]
        i += 1
        while i < len(correct_scores) and correct_scores[i] == current:
            equal_scores.append(correct_scores[i])
            i += 1

        rank_sum = [table.get(j+1,0) for j in range(current_index, i)]
        # print(rank_sum)
        # print(len(rank_sum))
        # print(current_index, i)
        rank_score = math.ceil(sum(rank_sum) / len(equal_scores))
        for score in equal_scores:
            score.score += rank_score

    print("\n".join([str(x.score) for x in scores]))




def main():
    lines = [line.strip() for line in sys.stdin]
    includedscoring(lines)
main()