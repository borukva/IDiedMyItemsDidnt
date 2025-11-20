**This is an updated fork of the original mod [I Died, My Items Didn't](https://github.com/DiemondPlayer/IDiedMyItemsDidnt).**

This mod makes so that the items that are dropped on player death are not despawnable. The items can still burn in lava or get lost in the void, but they will not despawn because of item age timer whatsoever. This does not affect mob drops, or items that were thrown out manually.

Feel free to include this project in modpacks!

**For Modpack creators**, there is a tag called force_despawn that you can modify using datapacks so that you can re-enable despawn for vanilla or modded items. You can find the datapack template [here](https://drive.google.com/drive/folders/13UWkAW-WW9dpValvN-VXGMajsAIVUCmH).

There is also [I Died, My Xp Didn't](https://modrinth.com/mod/idmxd), but it is not updated.

## How to use this mod as a dependency

This mod is hosted on **GitHub Packages**. To use it in your development environment, you need to configure your `build.gradle` to authenticate with GitHub.

### Step 1: Generate a GitHub Token
Because GitHub Packages requires authentication, you need a Personal Access Token (PAT).

1.  Go to [GitHub Settings > Developer Settings > Personal access tokens (Classic)](https://github.com/settings/tokens).
2.  Click **Generate new token (classic)**.
3.  **Scopes:** Select `read:packages`.
4.  Generate and copy the token.

### Step 2: Configure `gradle.properties`
**Do not** put your token directly in `build.gradle` if you plan to share your source code. Instead, add it to your user-level `gradle.properties` file (located at `~/.gradle/gradle.properties` on Linux/Mac or `C:\Users\YourName\.gradle\gradle.properties` on Windows).

Add the following lines:
```properties
gpr.user=YourGitHubUsername
gpr.key=ghp_YourCopiedTokenHere...
```

### Step 3: Update `build.gradle`
In your mod's `build.gradle`, add the repository and the dependency.

**Add the Repository:**
```groovy
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/borukva/IDiedMyItemsDidnt")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}
```

**Add the Dependency:**
```groovy
dependencies {
    // Replace VERSION with the specific version tag (e.g., 1.0.2-1.21.8)
    modImplementation "net.diemond_player.idmid:idmid:VERSION"
}
```

### CI/CD Note (GitHub Actions)
If you are building your mod using GitHub Actions, you don't need to create a manual token. GitHub Actions provides `GITHUB_TOKEN` automatically. Just ensure your workflow passes the environment variables:

```yaml
env:
  GITHUB_ACTOR: ${{ github.actor }}
  GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```