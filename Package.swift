// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorAdvancedHaptics",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorAdvancedHaptics",
            targets: ["AdvancedHapticsPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "AdvancedHapticsPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/AdvancedHapticsPlugin"),
        .testTarget(
            name: "AdvancedHapticsPluginTests",
            dependencies: ["AdvancedHapticsPlugin"],
            path: "ios/Tests/AdvancedHapticsPluginTests")
    ]
)