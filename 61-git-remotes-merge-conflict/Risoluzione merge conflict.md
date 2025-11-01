1. Clonazione locale repository
$ git clone  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.

2. Verifica di avere entrambi i branch remoti 
 $ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

3. Merge di feature dentro master 
$ git checkout master
Already on 'master'
Your branch is up to date with 'origin/master'.

$ git merge origin/feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.


4. Nota che si genera un conflict
5. Risoluzione merge conflict
$ javac HelloWorld.java

$ java HelloWorld
This program has been realised by Danilo Pianini
This program is running in a PC with 8 logic processors!

$ git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")

$ git add HelloWorld.java
$ git status
On branch master
Your branch is up to date with 'origin/master'.

All conflicts fixed but you are still merging.
  (use "git commit" to conclude merge)

Changes to be committed:
        modified:   HelloWorld.java

$ git commit -m 'Solved merge conflict'
[master 0e2cc15] Solved merge conflict

6. Creazione repo nel github personale 
7. Aggiunta repository come remote e elencazione remote 
$ git remote add merge-conflict-resolution https://github.com/D3lM0/merge-conflict-resolution.git
$ git remote -v
merge-conflict-resolution       https://github.com/D3lM0/merge-conflict-resolution.git (fetch)
merge-conflict-resolution       https://github.com/D3lM0/merge-conflict-resolution.git (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)

8. Push del branch master sul repository
$ git push merge-conflict-resolution master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 8 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.57 KiB | 321.00 KiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (4/4), done.
To https://github.com/D3lM0/merge-conflict-resolution.git
 * [new branch]      master -> master

9. Set del branch master remoto come upstream del master locale 
$ git branch --set-upstream-to=merge-conflict-resolution/master
branch 'master' set up to track 'merge-conflict-resolution/master'.

$ git status
On branch master
Your branch is up to date with 'merge-conflict-resolution/master'.

nothing to commit, working tree clean

