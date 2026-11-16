# Oaster Build and Deploy

## Prerequisites
- JDK 17+ (as required by chosen AGP/Compose/KMP versions)
- Android SDK + platform tools (for Android/TV builds)
- Kotlin/Gradle toolchain via Gradle wrapper
- Windows host or compatible environment for Windows packaging (Compose Desktop)

> Note: This environment snapshot does not include Android SDK/Gradle toolchains, so binaries cannot be produced here. Use a configured dev/CI environment.

## Build targets

### Android phone and tablet
- Debug APK: `./gradlew :androidApp:assembleDebug`
- Release APK: `./gradlew :androidApp:assembleRelease`
- Release AAB (Play-ready): `./gradlew :androidApp:bundleRelease`
- Output: `androidApp/build/outputs/apk/` and `androidApp/build/outputs/bundle/`
- Configure signing via `keystore.properties` / Gradle signing config (do not commit secrets).

### Android TV
- Same Android application module with leanback/TV configuration and manifest entries.
- Build TV-enabled APK: `./gradlew :androidApp:assembleRelease` (or dedicated TV variant if configured).
- Verify TV banner/icon, launcher intent, and D-pad navigation on 1080p/4K.

### Windows desktop/laptop
- Run: `./gradlew :desktopApp:run`
- Package distributable (installer/portable): use Compose Desktop packaging tasks, e.g. `./gradlew :desktopApp:packageDistributionForCurrentOS` or specific tasks like `packageMsi`/`packageExe`/portable image as configured.
- Output: `desktopApp/build/compose/binaries/`
- Ensure native window chrome, icon, minimize/maximize behavior, and keyboard shortcuts.

### (Stretch) Linux desktop
- If straightforward with Compose Desktop: `./gradlew :desktopApp:packageDeb` / `packageAppImage` (as configured).

## CI (GitHub Actions)
- Workflow: `.github/workflows/build.yml` (template provided).
- On push/PR: build Android debug/release artifacts and Windows desktop package on appropriate runners.
- Cache Gradle; upload artifacts for verification.
- Keep secrets (keystore, tokens) in GitHub encrypted secrets only.

## Release checklist
- [ ] All core features complete and polished.
- [ ] Performance checklist passed; no buffering/lag/jank.
- [ ] Device matrix verified (phone/tablet portrait+landscape, desktop resize, TV 1080p+4K).
- [ ] Accessibility pass complete.
- [ ] Version bumped, changelog/release notes prepared.
- [ ] Signed Android APK/AAB and Windows distributable produced.
- [ ] Store-ready assets prepared (icon, feature graphic placeholders, screenshots placeholders, descriptions).

## Store-ready asset placeholders
- App icon: adaptive icon layers + TV banner + Windows icon (from `/brand/logo/`).
- Screenshots: capture per device class after UI implementation.
- Short description: "Oaster by Cutozmie — a fast, beautiful local music player."
- Long description: highlight local library, liquid-glass design, adaptive layouts, gapless playback, and privacy/local-first focus.

## Security note
- Never commit signing keys, keystores, passwords, or personal access tokens.
- If a token was exposed, revoke/rotate it immediately and use `gh auth login`, credential helpers, or CI secrets instead.
