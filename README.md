# Full-Stack Foundations Starter

Team name: Best Team Ever


| Layer | Where it lives in this repo |
|---|---|
| Frontend | `frontend/index.html` |
| Backend | `src/main/java/todo/` |
| Database | `database/schema.sql` |

## The team loop

**Pull, Branch, Commit, Push, PR**

```
git pull                   # 1. get your team's latest work
git checkout -b my-branch-name   # 2. make your own branch
git add .                        # 3a. stage your changes
git commit -m "Add my intro"     # 3b. save with a message
git push -u origin my-branch-name  # 4. push your branch
                # 5. open a PR on GitHub
```

---

## Activity 1: PR

1. **One person:** click **Use this template > Create a new repository**. Make it **public**. Then go to **Settings > Collaborators** and add your teammates.
2. **Teammates:** accept the invite (check your email or github.com/notifications).
3. **Everyone:** clone the repo, then open it in your IDE
4. **Everyone:** make a branch named after yourself: `git checkout -b intro-yourname`
5. Create the file `team/your-github-username.md` with one line about yourself.
6. Commit, push, and open a pull request.
7. **A teammate** reviews your pull request, leaves a comment, and clicks **Merge**.

## Activity 2: Merge conflicts

1. Everyone: `git checkout main` then `git pull`.
2. Everyone: make a new branch, `git checkout -b team-name-yourname`.
3. Everyone: change the **Team name** line at the top of this README to your own idea.
4. Commit, push, and open a pull request.
5. Merge the **first** pull request. The others will now say **"This branch has conflicts."**
6. Click **Resolve conflicts**, choose the final team name together, delete the `<<<<<<<`, `=======`, and `>>>>>>>` lines, then **Mark as resolved** and **Commit merge**.

## Activity 3: Catch a bug with a test

Read the comments in `TaskList.java`. One method does **not** do what its comment promises.

1. Pick one driver. Everyone else watches and helps.
2. Driver: pull main, make a branch called `test-complete-task`.
3. In `src/test/java/todo/TaskListTest.java`, write a new test using the **three Es** (Expected, Edge, Error). Think about: what *should* happen if you complete a task that does not exist?
4. Commit, push, and open a pull request. Watch the **Checks** tab.
5. Red X? Your test caught a bug! Read the error, fix `TaskList.java`, push again, and watch for the green check.
6. Teammates review. Merge only when it is green.

---

## Running things 

**Run the tests:** open the Testing panel in VS Code (the flask icon) and click Run

**See all three layers connected:** run `TaskServer.java` (click Run above `main` in VS Code), then open <http://localhost:8080>.
